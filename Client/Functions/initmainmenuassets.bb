Function initmainmenuassets%()
    Local local0%
    mm = (New mainmenu)
    mma = (New mainmenuassets)
    mma\Field0 = scaleimageex(loadimage_strict("GFX\Menu\back.png"), menuscale, menuscale, $01)
    mma\Field1 = scaleimageex(loadimage_strict("GFX\Menu\SCP_text.png"), menuscale, menuscale, $01)
    mma\Field2 = scaleimageex(loadimage_strict("GFX\Menu\scp_173_back.png"), menuscale, menuscale, $01)
    mm\Field0[$00] = 1.0
    mm\Field0[$01] = 1.0
    For local0 = $00 To $01 Step $01
        buttonsfx[local0] = loadsound_strict((("SFX\Interact\Button" + (Str local0)) + ".ogg"))
    Next
    Return $00
End Function
