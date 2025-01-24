Function loadmisc%()
    Local local0%
    misc_i = (New miscinstance)
    misc_i\Field0[$00] = loadrmesh("GFX\Map\mt1.rmesh", Null, $01)
    misc_i\Field0[$01] = loadrmesh("GFX\Map\mt2.rmesh", Null, $01)
    misc_i\Field0[$02] = loadrmesh("GFX\Map\mt2C.rmesh", Null, $01)
    misc_i\Field0[$03] = loadrmesh("GFX\Map\mt3.rmesh", Null, $01)
    misc_i\Field0[$04] = loadrmesh("GFX\Map\mt4.rmesh", Null, $01)
    misc_i\Field0[$05] = loadrmesh("GFX\Map\mt2_elevator.rmesh", Null, $01)
    misc_i\Field0[$06] = loadrmesh("GFX\Map\mt1_generator.rmesh", Null, $01)
    For local0 = $00 To $06 Step $01
        hideentity(misc_i\Field0[local0])
    Next
    misc_i\Field1 = loadmesh_strict("GFX\Items\cup_liquid.b3d", $00)
    hideentity(misc_i\Field1)
    For local0 = $00 To $01 Step $01
        misc_i\Field2[local0] = loadtexture_strict((("GFX\Particles\light(" + (Str local0)) + ").png"), $01, $01, $00)
    Next
    misc_i\Field3 = loadtexture_strict("GFX\Particles\advanced_light.png", $01, $01, $00)
    Return $00
End Function
