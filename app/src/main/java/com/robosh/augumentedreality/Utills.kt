package com.robosh.augumentedreality

val OREST_LAB = "<!doctype html>\n" +
        "<html lang=en >\n" +
        "<head>\n" +
        "<title>Rewolution With Dumping Circular Wawes</title>\n" +
        "<meta charset=utf-8 >\n" +
        "<meta name=viewport content=width=device-width,user-scalable=no,minimum-scale=1.0,maximum-scale=1.0 >\n" +
        "</head>\n" +
        "<body>\n" +
        "<script src=http://mrdoob.github.io/three.js/build/three.min.js ></script>\n" +
        "<script src=http://mrdoob.github.io/three.js/examples/js/controls/TrackballControls.js ></script>\n" +
        "dasdas\n" +
        "\n" +
        "<script>\n" +
        "\n" +
        "\tvar renderer, scene, controls;\n" +
        "\tvar geometry, material, mesh;////\n" +
        "\tvar pi = Math.PI;\n" +
        "\tvar x, y, z;\n" +
        "\n" +
        "\tlet camera;\n" +
        "\n" +
        "\n" +
        "\tvar a = 0.7;\n" +
        "\tvar b = 0.9;\n" +
        "\tvar a = 0.7, aMin = -5, aMax = 5, aStep = 0.05;///\n" +
        "\tvar b = 0.9, bMin = -5, bMax = 5, bStep = 0.05;\n" +
        "\tvar c = 0.7, cMin = -5, cMax = 5, cStep = 0.05;\n" +
        "\tvar d = 0.9, dMin = -5, dMax = 5, dStep = 0.05;///\n" +
        "\n" +
        "\tvar e = 0.7, eMin = -5, eMax = 5, eStep = 0.05;\n" +
        "\n" +
        "\tinit();\n" +
        "\tanimate();\n" +
        "\n" +
        "\tfunction init() {\n" +
        "\n" +
        "\t\tcamera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 0.01, 100 );\n" +
        "\t\tcamera.position.z = 3;////\n" +
        "\t\tcamera.focalLength = 3;\n" +
        "\n" +
        "\t\t// document.body.style.cssText = 'margin: 0; overflow: hidden; ' ;///\n" +
        "\n" +
        "\t\trenderer = new THREE.WebGLRenderer( { alpha: 1, antialias: true, clearColor: 0xffffff }  );\n" +
        "\t\trenderer.setSize( window.innerWidth, window.innerHeight );/// \n" +
        "\t\tdocument.body.appendChild( renderer.domElement );\n" +
        "\t\tscene = new THREE.Scene();\n" +
        "\n" +
        "\t\tcamera = new THREE.PerspectiveCamera( 40, window.innerWidth / window.innerHeight, 1, 1000 );\n" +
        "\t\tcamera.position.set( 100, 100, -100 );/// here?\n" +
        "\t\tcontrols = new THREE.TrackballControls( camera, renderer.domElement );\n" +
        "\n" +
        "\t\tgeometry = new THREE.ParametricGeometry( rewolutionWithDumpingCircularWawes, 36, 100 );\n" +
        "\t\tmaterial = new THREE.MeshNormalMaterial( { shading: THREE.SmoothShading, side: 2 } )\n" +
        "\t\tmesh = new THREE.Mesh( geometry, material );\n" +
        "\t\tscene.add( mesh );\n" +
        "\t}\n" +
        "\n" +
        "\tfunction rewolutionWithDumpingCircularWawes(v, u, vector) {\n" +
        "\n" +
        "\t\tkoef = 100;\n" +
        "        u *= koef\n" +
        "        v *= koef\n" +
        "\n" +
        "        radius = v;\n" +
        "        m = 6;\n" +
        "        a = 4*m;\n" +
        "        b = 6*m;\n" +
        "        n = 0.5;\n" +
        "\n" +
        "        phi = 0;\n" +
        "        w = (m *(Math.PI)) / b +1;\n" +
        "\n" +
        "        vector.x = radius * Math.cos(u);\n" +
        "        vector.y = radius * Math.sin(u);\n" +
        "        vector.z = a * Math.pow(2.71, (-radius * n)) * Math.sin(w * radius + phi);\n" +
        "        // console.log(radius <= b)\n" +
        "        console.log(v)\n" +
        "    }\n" +
        "\n" +
        "\tfunction exp( a ){ return Math.exp( a ); }\n" +
        "\tfunction cos( a ){ return Math.cos( a ); }\n" +
        "\tfunction sin( a ){ return Math.sin( a ); }\n" +
        "\n" +
        "\tfunction animate() {\n" +
        "\t\trequestAnimationFrame( animate );\n" +
        "\t\trenderer.render( scene, camera );\n" +
        "\t\tcontrols.update();\n" +
        "\t}\n" +
        "\n" +
        "\n" +
        "</script>\n" +
        "</body>\n" +
        "</html>"