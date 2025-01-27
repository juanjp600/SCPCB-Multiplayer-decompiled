Function loadoptionsini%()
    opt\Field2 = inigetint(optionfile, "Graphics", "Enable Bump Mapping", $01, $01)
    opt\Field5 = inigetint(optionfile, "Graphics", "VSync", $01, $01)
    opt\Field1 = inigetint(optionfile, "Graphics", "Anti-Aliasing", $01, $01)
    opt\Field4 = inigetint(optionfile, "Graphics", "Advanced Room Lighting", $01, $01)
    opt\Field6 = inigetfloat(optionfile, "Graphics", "Screen Gamma", 1.0, $01)
    opt\Field7 = 1.0
    opt\Field0 = inigetint(optionfile, "Graphics", "Particle Amount", $02, $01)
    opt\Field8 = inigetint(optionfile, "Graphics", "Texture Details", $02, $01)
    Select opt\Field8
        Case $00
            opt\Field9 = 0.8
        Case $01
            opt\Field9 = 0.4
        Case $02
            opt\Field9 = 0.0
        Case $03
            opt\Field9 = -0.4
        Case $04
            opt\Field9 = -0.8
    End Select
    opt\Field3 = inigetint(optionfile, "Graphics", "Save Textures In VRAM", $01, $01)
    opt\Field10 = inigetfloat(optionfile, "Graphics", "FOV", 60.0, $01)
    opt\Field11 = (opt\Field10 - 40.0)
    opt\Field12 = inigetint(optionfile, "Graphics", "Anisotropic Filtering", $02, $01)
    Select opt\Field12
        Case $00
            opt\Field13 = $00
        Case $01
            opt\Field13 = $02
        Case $02
            opt\Field13 = $04
        Case $03
            opt\Field13 = $08
        Case $04
            opt\Field13 = $10
    End Select
    opt\Field14 = inigetint(optionfile, "Graphics", "Security Cam Render Interval", $02, $01)
    Select opt\Field14
        Case $00
            opt\Field15 = 24.0
        Case $01
            opt\Field15 = 18.0
        Case $02
            opt\Field15 = 12.0
        Case $03
            opt\Field15 = 6.0
        Case $04
            opt\Field15 = 0.0
    End Select
    opt\Field17 = inigetfloat(optionfile, "Audio", "Master Volume", 0.5, $01)
    opt\Field16 = opt\Field17
    opt\Field18 = inigetfloat(optionfile, "Audio", "Music Volume", 0.5, $01)
    opt\Field19 = 1.0
    opt\Field20 = inigetfloat(optionfile, "Audio", "Sound Volume", 0.5, $01)
    opt\Field21 = inigetfloat(optionfile, "Audio", "Voice Volume", 0.5, $01)
    opt\Field22 = inigetint(optionfile, "Audio", "SFX Release", $01, $01)
    opt\Field23 = opt\Field22
    opt\Field24 = inigetint(optionfile, "Audio", "User Track Setting", $00, $01)
    opt\Field25 = inigetint(optionfile, "Audio", "Enable Subtitles", $00, $01)
    opt\Field26 = inigetint(optionfile, "Audio", "Override Subtitle Color", $00, $01)
    opt\Field27 = inigetint(optionfile, "Audio", "Subtitles Color R", $FF, $01)
    opt\Field28 = inigetint(optionfile, "Audio", "Subtitles Color G", $FF, $01)
    opt\Field29 = inigetint(optionfile, "Audio", "Subtitles Color B", $FF, $01)
    opt\Field45 = inigetfloat(optionfile, "Controls", "Mouse Sensitivity", 0.0, $01)
    opt\Field43 = inigetint(optionfile, "Controls", "Invert Mouse By X-Axis", $00, $01)
    opt\Field44 = inigetint(optionfile, "Controls", "Invert Mouse By Y-Axis", $00, $01)
    opt\Field42 = inigetfloat(optionfile, "Controls", "Mouse Smoothing", 1.0, $01)
    key\Field3 = inigetint(optionfile, "Controls", "Up Key", $11, $01)
    key\Field1 = inigetint(optionfile, "Controls", "Left Key", $1E, $01)
    key\Field4 = inigetint(optionfile, "Controls", "Down Key", $1F, $01)
    key\Field2 = inigetint(optionfile, "Controls", "Right Key", $20, $01)
    key\Field7 = inigetint(optionfile, "Controls", "Sprint Key", $2A, $01)
    key\Field10 = inigetint(optionfile, "Controls", "Crouch Key", $1D, $01)
    key\Field8 = inigetint(optionfile, "Controls", "Blink Key", $39, $01)
    key\Field6 = inigetint(optionfile, "Controls", "Inventory Key", $0F, $01)
    key\Field9 = inigetint(optionfile, "Controls", "Save Key", $3F, $01)
    key\Field5 = inigetint(optionfile, "Controls", "Console Key", $3D, $01)
    key\Field11 = inigetint(optionfile, "Controls", "Screenshot Key", $3B, $01)
    key\Field12 = inigetint(optionfile, "Controls", "Lean Left Key", $10, $01)
    key\Field13 = inigetint(optionfile, "Controls", "Lean Right Key", $12, $01)
    opt\Field32 = inigetint(optionfile, "Advanced", "Enable HUD", $01, $01)
    opt\Field31 = inigetint(optionfile, "Advanced", "Enable Console", $00, $01)
    opt\Field34 = inigetint(optionfile, "Advanced", "Console Auto Opening", $00, $01)
    opt\Field30 = inigetint(optionfile, "Advanced", "Enable Achievement Popup", $01, $01)
    opt\Field37 = inigetint(optionfile, "Advanced", "Enable Auto Save", $01, $01)
    opt\Field33 = inigetint(optionfile, "Advanced", "Show FPS", $00, $01)
    opt\Field35 = inigetint(optionfile, "Advanced", "Frame Limit", $00, $01)
    opt\Field36 = (((Float opt\Field35) - 19.0) / 100.0)
    opt\Field38 = inigetint(optionfile, "Advanced", "Smooth Bars", $01, $01)
    opt\Field39 = inigetint(optionfile, "Advanced", "Vignette Enabled", $01, $01)
    opt\Field40 = inigetint(optionfile, "Advanced", "Play Startup Videos", $01, $01)
    opt\Field41 = inigetint(optionfile, "Advanced", "Launcher Enabled", $01, $01)
    opt\Field48 = inigetstring(optionfile, "Multiplayer", "Voice device", "", $01)
    opt\Field46 = inigetstring(optionfile, "Multiplayer", "Nickname", "Player", $01)
    opt\Field47 = inigetfloat(optionfile, "Multiplayer", "Voice Volume", 1.0, $01)
    key\Field14 = inigetint(optionfile, "Multiplayer", "Voice Key", $2F, $01)
    key\Field15 = inigetint(optionfile, "Multiplayer", "Chat Key", $15, $01)
    opt\Field49 = inigetint(optionfile, "Global", "Width", desktopwidth(), $01)
    opt\Field50 = inigetint(optionfile, "Global", "Height", desktopheight(), $01)
    opt\Field51 = inigetint(optionfile, "Global", "Display Mode", $01, $01)
    opt\Field52 = inigetint(optionfile, "Global", "GFX Driver", $01, $01)
    opt\Field53 = inigetint(optionfile, "Global", "Enable Intro", $01, $01)
    opt\Field54 = inigetint(optionfile, "Global", "Debug Mode", $00, $01)
    opt\Field55 = inigetstring(optionfile, "Global", "Language", "en", $01)
    opt\Field59 = inigetint(optionfile, "Global", "No Progress Bar", $00, $01)
    Return $00
End Function
