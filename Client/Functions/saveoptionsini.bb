Function saveoptionsini%()
    putinivalue(optionfile, "options", "mouse sensitivity", (Str mousesens))
    putinivalue(optionfile, "options", "invert mouse y", (Str invertmouse))
    putinivalue(optionfile, "options", "bump mapping enabled", (Str bumpenabled))
    putinivalue(optionfile, "options", "HUD enabled", (Str hudenabled))
    putinivalue(optionfile, "options", "screengamma", (Str screengamma))
    putinivalue(optionfile, "options", "antialias", (Str opt_antialias))
    putinivalue(optionfile, "options", "vsync", (Str verticalsync))
    putinivalue(optionfile, "options", "show FPS", (Str showfps))
    putinivalue(optionfile, "options", "showscpviewmodel", (Str showscpviewmodel))
    putinivalue(optionfile, "options", "framelimit", (Str framelimit))
    putinivalue(optionfile, "options", "achievement popup enabled", (Str achvmsgenabled))
    putinivalue(optionfile, "options", "room lights enabled", (Str enableroomlights))
    putinivalue(optionfile, "options", "texture details", (Str texturedetails))
    putinivalue(optionfile, "console", "enabled", (Str canopenconsole))
    putinivalue(optionfile, "console", "auto opening", (Str consoleopening))
    putinivalue(optionfile, "options", "antialiased text", (Str aatextenable))
    putinivalue(optionfile, "options", "particle amount", (Str particleamount))
    putinivalue(optionfile, "options", "enable vram", (Str enablevram))
    putinivalue(optionfile, "options", "mouse smoothing", (Str mousesmooth))
    putinivalue(optionfile, "options", "gammaoff", (Str turnongamma))
    putinivalue(optionfile, "options", "cameraupd", (Str camupdate))
    putinivalue(optionfile, "options", "cameraquality", (Str camquality))
    putinivalue(optionfile, "options", "removedecals", (Str removedecals))
    putinivalue(optionfile, "options", "removeparticles", (Str removeparticles))
    putinivalue(optionfile, "options", "fov", (Str mainfov))
    putinivalue(optionfile, "options", "enablebullets", (Str enablebullets))
    putinivalue(optionfile, "audio", "music volume", (Str musicvolume))
    putinivalue(optionfile, "audio", "sound volume", (Str prevsfxvolume))
    putinivalue(optionfile, "audio", "sfx release", (Str enablesfxrelease))
    putinivalue(optionfile, "audio", "enable user tracks", (Str enableusertracks))
    putinivalue(optionfile, "audio", "user track setting", (Str usertrackmode))
    putinivalue(optionfile, "binds", "Right key", (Str key_right))
    putinivalue(optionfile, "binds", "Left key", (Str key_left))
    putinivalue(optionfile, "binds", "Up key", (Str key_up))
    putinivalue(optionfile, "binds", "Down key", (Str key_down))
    putinivalue(optionfile, "binds", "Blink key", (Str key_blink))
    putinivalue(optionfile, "binds", "Sprint key", (Str key_sprint))
    putinivalue(optionfile, "binds", "Inventory key", (Str key_inv))
    putinivalue(optionfile, "binds", "Crouch key", (Str key_crouch))
    putinivalue(optionfile, "binds", "Save key", (Str key_save))
    putinivalue(optionfile, "binds", "Console key", (Str key_console))
    putinivalue(optionfile, "binds", "mouseinteract", (Str mouseinteract))
    putinivalue(optionfile, "binds", "Voice key", (Str key_voice))
    putinivalue(optionfile, "binds", "Chat key", (Str key_chat))
    putinivalue(optionfile, "binds", "Jump key", (Str key_jump))
    putinivalue(optionfile, "binds", "LeanR key", (Str key_leanr))
    putinivalue(optionfile, "binds", "LeanL key", (Str key_leanl))
    putinivalue(optionfile, "binds", "Using key", (Str key_using))
    Return $00
End Function
