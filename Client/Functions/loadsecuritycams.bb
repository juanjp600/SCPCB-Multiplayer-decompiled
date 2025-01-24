Function loadsecuritycams%()
    Local local0%
    sc_i = (New securitycaminstance)
    For local0 = $00 To $01 Step $01
        sc_i\Field1[local0] = loadtexture_strict((("GFX\Map\Textures\camera(" + (Str (local0 + $01))) + ").png"), $01, $01, $01)
    Next
    sc_i\Field0[$00] = loadmesh_strict("GFX\Map\Props\CamBase.b3d", $00)
    sc_i\Field0[$01] = loadmesh_strict("GFX\Map\Props\CamHead.b3d", $00)
    For local0 = $00 To $01 Step $01
        hideentity(sc_i\Field0[local0])
    Next
    sc_i\Field2 = createtextureusingcachesystem($200, $200, ((opt\Field3 Shl $08) + $01), $01, $01)
    Return $00
End Function
