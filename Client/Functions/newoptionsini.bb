Function newoptionsini%()
    putinivalue(optionfile, "options", "brightness", "50")
    putinivalue(optionfile, "options", "mouse sensitivity", "0.0")
    putinivalue(optionfile, "options", "invert mouse y", "0")
    putinivalue(optionfile, "options", "bump mapping enabled", "1")
    putinivalue(optionfile, "options", "HUD enabled", "1")
    putinivalue(optionfile, "options", "screengamma", "1.0")
    putinivalue(optionfile, "options", "antialias", "1")
    putinivalue(optionfile, "options", "vsync", "0")
    putinivalue(optionfile, "options", "show FPS", "1")
    putinivalue(optionfile, "options", "showscpviewmodel", "1")
    putinivalue(optionfile, "options", "camera fog near", "0.5")
    putinivalue(optionfile, "options", "camera fog far", "6.0")
    putinivalue(optionfile, "options", "fog r", "0")
    putinivalue(optionfile, "options", "fog g", "0")
    putinivalue(optionfile, "options", "fog b", "0")
    putinivalue(optionfile, "options", "framelimit", (Str framelimit))
    putinivalue(optionfile, "options", "achievement popup enabled", "1")
    putinivalue(optionfile, "options", "room lights enabled", "1")
    putinivalue(optionfile, "options", "texture details", "2")
    putinivalue(optionfile, "console", "enabled", "0")
    putinivalue(optionfile, "console", "auto opening", "0")
    putinivalue(optionfile, "options", "antialiased text", "0")
    putinivalue(optionfile, "options", "particle amount", "2")
    putinivalue(optionfile, "options", "enable vram", "0")
    putinivalue(optionfile, "options", "mouse smoothing", "1.0")
    putinivalue(optionfile, "options", "gammaoff", "0")
    putinivalue(optionfile, "options", "cameraupd", "2")
    putinivalue(optionfile, "options", "cameraquality", "2")
    putinivalue(optionfile, "options", "removedecals", "0")
    putinivalue(optionfile, "options", "removeparticles", "0")
    putinivalue(optionfile, "options", "fov", "70.0")
    putinivalue(optionfile, "options", "enablebullets", "1")
    putinivalue(optionfile, "options", "play startup video", "1")
    putinivalue(optionfile, "audio", "music volume", "1.0")
    putinivalue(optionfile, "audio", "sound volume", "1.0")
    putinivalue(optionfile, "audio", "sfx release", "1")
    putinivalue(optionfile, "audio", "enable user tracks", "1")
    putinivalue(optionfile, "audio", "user track setting", "1")
    putinivalue(optionfile, "binds", "Right key", "32")
    putinivalue(optionfile, "binds", "Left key", "30")
    putinivalue(optionfile, "binds", "Up key", "17")
    putinivalue(optionfile, "binds", "Down key", "31")
    putinivalue(optionfile, "binds", "Blink key", "48")
    putinivalue(optionfile, "binds", "Sprint key", "42")
    putinivalue(optionfile, "binds", "Inventory key", "15")
    putinivalue(optionfile, "binds", "Crouch key", "29")
    putinivalue(optionfile, "binds", "Save key", "63")
    putinivalue(optionfile, "binds", "Console key", "61")
    putinivalue(optionfile, "binds", "mouseinteract", "1")
    putinivalue(optionfile, "binds", "Voice key", "47")
    putinivalue(optionfile, "binds", "Chat key", "64")
    putinivalue(optionfile, "binds", "Jump key", "57")
    putinivalue(optionfile, "binds", "LeanR key", "18")
    putinivalue(optionfile, "binds", "LeanL key", "16")
    putinivalue(optionfile, "binds", "Using key", "33")
    putinivalue(optionfile, "launcher", "launcher width", "640")
    putinivalue(optionfile, "launcher", "launcher height", "480")
    putinivalue(optionfile, "launcher", "launcher enabled", "1")
    Return $00
End Function
