Function loadlevers%()
    Local local0%
    lvr_i = (New leverinstance)
    lvr_i\Field0[$00] = loadmesh_strict("GFX\Map\Props\LeverBase.b3d", $00)
    lvr_i\Field0[$01] = loadmesh_strict("GFX\Map\Props\LeverHandle.b3d", $00)
    For local0 = $00 To $01 Step $01
        hideentity(lvr_i\Field0[local0])
    Next
    Return $00
End Function
