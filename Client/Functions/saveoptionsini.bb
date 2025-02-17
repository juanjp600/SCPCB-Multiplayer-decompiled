Function saveoptionsini%(arg0%)
    iniwritestring(optionfile, "Graphics", "Enable Bump Mapping", (Str opt\Field2), $01)
    iniwritestring(optionfile, "Graphics", "VSync", (Str opt\Field5), $01)
    iniwritestring(optionfile, "Graphics", "Anti-Aliasing", (Str opt\Field1), $01)
    iniwritestring(optionfile, "Graphics", "Advanced Room Lighting", (Str opt\Field4), $01)
    iniwritestring(optionfile, "Graphics", "Screen Gamma", (Str opt\Field6), $01)
    iniwritestring(optionfile, "Graphics", "Particle Amount", (Str opt\Field0), $01)
    iniwritestring(optionfile, "Graphics", "Texture Details", (Str opt\Field8), $01)
    iniwritestring(optionfile, "Graphics", "Save Textures In VRAM", (Str opt\Field3), $01)
    iniwritestring(optionfile, "Graphics", "FOV", (Str (Int opt\Field10)), $01)
    iniwritestring(optionfile, "Graphics", "Anisotropic Filtering", (Str opt\Field12), $01)
    iniwritestring(optionfile, "Graphics", "Security Cam Render Interval", (Str opt\Field14), $01)
    iniwritestring(optionfile, "Audio", "Master Volume", (Str opt\Field17), $01)
    iniwritestring(optionfile, "Audio", "Music Volume", (Str opt\Field18), $01)
    iniwritestring(optionfile, "Audio", "Sound Volume", (Str opt\Field20), $01)
    iniwritestring(optionfile, "Audio", "Voice Volume", (Str opt\Field21), $01)
    iniwritestring(optionfile, "Audio", "SFX Release", (Str opt\Field22), $01)
    iniwritestring(optionfile, "Audio", "User Track Setting", (Str opt\Field24), $01)
    iniwritestring(optionfile, "Audio", "Enable Subtitles", (Str opt\Field25), $01)
    iniwritestring(optionfile, "Audio", "Override Subtitle Color", (Str opt\Field26), $01)
    iniwritestring(optionfile, "Audio", "Subtitles Color R", (Str opt\Field27), $01)
    iniwritestring(optionfile, "Audio", "Subtitles Color G", (Str opt\Field28), $01)
    iniwritestring(optionfile, "Audio", "Subtitles Color B", (Str opt\Field29), $01)
    iniwritestring(optionfile, "Controls", "Mouse Sensitivity", (Str opt\Field45), $01)
    iniwritestring(optionfile, "Controls", "Invert Mouse By X-Axis", (Str opt\Field43), $01)
    iniwritestring(optionfile, "Controls", "Invert Mouse By Y-Axis", (Str opt\Field44), $01)
    iniwritestring(optionfile, "Controls", "Mouse Smoothing", (Str opt\Field42), $01)
    iniwritestring(optionfile, "Controls", "Up Key", (Str key\Field3), $01)
    iniwritestring(optionfile, "Controls", "Left Key", (Str key\Field1), $01)
    iniwritestring(optionfile, "Controls", "Down Key", (Str key\Field4), $01)
    iniwritestring(optionfile, "Controls", "Right Key", (Str key\Field2), $01)
    iniwritestring(optionfile, "Controls", "Sprint Key", (Str key\Field7), $01)
    iniwritestring(optionfile, "Controls", "Crouch Key", (Str key\Field10), $01)
    iniwritestring(optionfile, "Controls", "Blink Key", (Str key\Field8), $01)
    iniwritestring(optionfile, "Controls", "Inventory Key", (Str key\Field6), $01)
    iniwritestring(optionfile, "Controls", "Save Key", (Str key\Field9), $01)
    iniwritestring(optionfile, "Controls", "Console Key", (Str key\Field5), $01)
    iniwritestring(optionfile, "Controls", "Screenshot Key", (Str key\Field11), $01)
    iniwritestring(optionfile, "Controls", "Lean Left Key", (Str key\Field12), $01)
    iniwritestring(optionfile, "Controls", "Lean Right Key", (Str key\Field13), $01)
    iniwritestring(optionfile, "Advanced", "Enable HUD", (Str opt\Field32), $01)
    iniwritestring(optionfile, "Advanced", "Enable Console", (Str opt\Field31), $01)
    iniwritestring(optionfile, "Advanced", "Console Auto Opening", (Str opt\Field34), $01)
    iniwritestring(optionfile, "Advanced", "Enable Achievement Popup", (Str opt\Field30), $01)
    iniwritestring(optionfile, "Advanced", "Enable Auto Save", (Str opt\Field37), $01)
    iniwritestring(optionfile, "Advanced", "Show FPS", (Str opt\Field33), $01)
    iniwritestring(optionfile, "Advanced", "Frame Limit", (Str opt\Field35), $01)
    iniwritestring(optionfile, "Advanced", "Smooth Bars", (Str opt\Field38), $01)
    iniwritestring(optionfile, "Advanced", "Vignette Enabled", (Str opt\Field39), $01)
    iniwritestring(optionfile, "Advanced", "Play Startup Videos", (Str opt\Field40), $01)
    iniwritestring(optionfile, "Advanced", "Launcher Enabled", (Str opt\Field41), $01)
    iniwritestring(optionfile, "Multiplayer", "Voice device", opt\Field48, $01)
    iniwritestring(optionfile, "Multiplayer", "Nickname", opt\Field46, $01)
    iniwritestring(optionfile, "Multiplayer", "Voice Volume", (Str opt\Field47), $01)
    iniwritestring(optionfile, "Multiplayer", "Voice Key", (Str key\Field14), $01)
    iniwritestring(optionfile, "Multiplayer", "Chat Key", (Str key\Field15), $01)
    If (arg0 <> 0) Then
        iniwritestring(optionfile, "Global", "Enable Intro", (Str opt\Field53), $01)
    EndIf
    iniwritestring(optionfile, "Global", "Language", opt\Field55, $01)
    iniwritestring(optionfile, "Global", "No Progress Bar", (Str opt\Field59), $01)
    Return $00
End Function
