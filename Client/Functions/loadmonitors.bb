Function loadmonitors%()
    Local local0%
    mon_i = (New monitorinstance)
    mon_i\Field1[$00] = loadtexture_strict("GFX\Overlays\monitor_overlay.png", $01, $01, $00)
    For local0 = $01 To $03 Step $01
        mon_i\Field1[local0] = loadtexture_strict((("GFX\Map\Textures\lockdown_screen(" + (Str local0)) + ").png"), $01, $01, $00)
    Next
    mon_i\Field1[$04] = createtextureusingcachesystem($01, $01, ((opt\Field3 Shl $08) + $01), $01, $01)
    setbuffer(texturebuffer(mon_i\Field1[$04], $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    For local0 = $05 To $0B Step $01
        mon_i\Field1[local0] = loadtexture_strict((("GFX\Overlays\scp_079_overlay(" + (Str (local0 - $04))) + ").png"), $01, $01, $00)
    Next
    For local0 = $0C To $10 Step $01
        mon_i\Field1[local0] = loadtexture_strict((("GFX\Overlays\scp_895_overlay(" + (Str (local0 - $0B))) + ").png"), $01, $01, $00)
    Next
    mon_i\Field0[$00] = loadmesh_strict("GFX\Map\Props\monitor2.b3d", $00)
    mon_i\Field0[$01] = loadmesh_strict("GFX\Map\Props\monitor_checkpoint.b3d", $00)
    For local0 = $00 To $01 Step $01
        hideentity(mon_i\Field0[local0])
    Next
    Return $00
End Function
