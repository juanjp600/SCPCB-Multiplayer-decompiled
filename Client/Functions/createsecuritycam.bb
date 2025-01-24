Function createsecuritycam.securitycams(arg0.rooms, arg1#, arg2#, arg3#, arg4#, arg5%, arg6#, arg7#, arg8#, arg9#, arg10#, arg11#)
    Local local0.securitycams
    Local local1#
    Local local2#
    Local local3#
    local0 = (New securitycams)
    local0\Field16 = arg0
    local0\Field22 = $00
    local0\Field21 = $00
    local0\Field0 = copyentity(sc_i\Field0[$00], $00)
    scaleentity(local0\Field0, 0.0015, 0.0015, 0.0015, $00)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    If (arg0 <> Null) Then
        entityparent(local0\Field0, arg0\Field2, $01)
    EndIf
    hideentity(local0\Field0)
    local0\Field1 = copyentity(sc_i\Field0[$01], $00)
    scaleentity(local0\Field1, 0.01, 0.01, 0.01, $00)
    rotateentity(local0\Field1, arg4, 0.0, 0.0, $00)
    hideentity(local0\Field1)
    local0\Field5 = arg5
    If (arg5 <> 0) Then
        local0\Field19 = $01
        local0\Field15 = opt\Field15
        local1 = (1.0 / 142.2222)
        local2 = ((meshwidth(mon_i\Field0[$00]) * local1) * 0.475)
        local3 = ((meshheight(mon_i\Field0[$00]) * local1) * 0.475)
        local0\Field4 = createsprite($00)
        scalesprite(local0\Field4, local2, local3)
        positionentity(local0\Field4, arg6, arg7, arg8, $00)
        rotateentity(local0\Field4, arg9, arg10, arg11, $00)
        entityfx(local0\Field4, $11)
        spriteviewmode(local0\Field4, $02)
        entitytexture(local0\Field4, sc_i\Field2, $00, $00)
        If (arg0 <> Null) Then
            entityparent(local0\Field4, arg0\Field2, $01)
        EndIf
        hideentity(local0\Field4)
        local0\Field7 = createsprite(local0\Field4)
        scalesprite(local0\Field7, local2, local3)
        moveentity(local0\Field7, 0.0, 0.0, -0.005)
        entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
        spriteviewmode(local0\Field7, $02)
        entityfx(local0\Field7, $01)
        entityblend(local0\Field7, $03)
        hideentity(local0\Field7)
        local0\Field2 = copyentity(mon_i\Field0[$00], local0\Field4)
        scaleentity(local0\Field2, local1, local1, local1, $00)
        local0\Field6 = createcamera($00)
        cameraviewport(local0\Field6, $00, $00, $200, $200)
        camerarange(local0\Field6, 0.05, 8.0)
        camerazoom(local0\Field6, 0.8)
        If (local0\Field16\Field7\Field6 <> $04) Then
            camerafogmode(local0\Field6, $01)
            camerafogrange(local0\Field6, 0.1, 6.0)
        EndIf
        hideentity(local0\Field6)
    EndIf
    Return local0
    Return Null
End Function
