{
  description = "Tower Defense Game";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
      in
      {
        devShells.default = pkgs.mkShell {
          buildInputs = with pkgs; [
            jdk23
            xorg.libX11
            xorg.libXext
            xorg.libXrender
            xorg.libXtst
            xorg.libXi
          ];

          shellHook = ''
            export LD_LIBRARY_PATH=${pkgs.lib.makeLibraryPath [
              pkgs.xorg.libX11
              pkgs.xorg.libXext
              pkgs.xorg.libXrender
              pkgs.xorg.libXtst
              pkgs.xorg.libXi
            ]}:$LD_LIBRARY_PATH
          '';
        };

        packages.default = pkgs.stdenv.mkDerivation {
          pname = "tower-defense";
          version = "0.1.0";
          src = ./.;

          buildInputs = with pkgs; [
            maven
          ];

          buildPhase = ''
            mvn package
          '';

          installPhase = ''
            mkdir -p $out/bin
            cp target/*.jar $out/bin/
          '';
        };
      }
    );
}