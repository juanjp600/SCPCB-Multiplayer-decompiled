Function loaddecals%()
    Local local0%
    de_i = (New decalinstance)
    For local0 = $00 To $01 Step $01
        de_i\Field0[local0] = loadtexture_strict((("GFX\Decals\corrosive_decal(" + (Str local0)) + ").png"), $03, $01, $00)
    Next
    For local0 = $02 To $07 Step $01
        de_i\Field0[local0] = loadtexture_strict((("GFX\Decals\blood_decal(" + (Str (local0 - $02))) + ").png"), $03, $01, $00)
    Next
    For local0 = $08 To $0D Step $01
        de_i\Field0[local0] = loadtexture_strict((("GFX\Decals\pd_decal(" + (Str (local0 - $08))) + ").png"), $03, $01, $00)
    Next
    For local0 = $0E To $0F Step $01
        de_i\Field0[local0] = loadtexture_strict((("GFX\Decals\bullet_hole_decal(" + (Str (local0 - $0E))) + ").png"), $03, $01, $00)
    Next
    For local0 = $10 To $11 Step $01
        de_i\Field0[local0] = loadtexture_strict((("GFX\Decals\blood_drop_decal(" + (Str (local0 - $10))) + ").png"), $03, $01, $00)
    Next
    de_i\Field0[$13] = loadtexture_strict("GFX\Decals\scp_409_decal.png", $03, $01, $00)
    de_i\Field0[$12] = loadtexture_strict("GFX\Decals\scp_427_decal.png", $03, $01, $00)
    de_i\Field0[$14] = loadtexture_strict("GFX\Decals\scp_999_decal.png", $03, $01, $00)
    de_i\Field0[$15] = loadtexture_strict("GFX\Decals\water_decal.png", $03, $01, $00)
    If (s2imapcontains(unlockedachievements, "keter") <> 0) Then
        de_i\Field0[$16] = loadtexture_strict("GFX\Menu\Achievements\AchvKeter.png", $01, $01, $00)
    EndIf
    If (s2imapcontains(unlockedachievements, "apollyon") <> 0) Then
        de_i\Field0[$17] = loadtexture_strict("GFX\Menu\Achievements\AchvApollyon.png", $03, $01, $00)
    EndIf
    de_i\Field0[$18] = loadtexture_strict("GFX\Decals\cracked_glass_decal.png", $03, $01, $00)
    Return $00
End Function
