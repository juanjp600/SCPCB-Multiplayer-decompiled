Function addlight.lights(arg0.rooms, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%, arg8%, arg9%)
    Local local0.lights
    Local local1%
    Local local2%
    local0 = (New lights)
    local0\Field12 = arg0
    local0\Field0 = createlight(arg4, $00)
    lightrange(local0\Field0, arg5)
    lightcolor(local0\Field0, (Float arg6), (Float arg7), (Float arg8))
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    If (arg0 <> Null) Then
        entityparent(local0\Field0, arg0\Field2, $01)
    EndIf
    hideentity(local0\Field0)
    If (arg9 <> 0) Then
        local0\Field1 = createsprite($00)
        positionentity(local0\Field1, arg1, arg2, arg3, $00)
        scalesprite(local0\Field1, 0.13, 0.13)
        entitytexture(local0\Field1, misc_i\Field2[$00], $00, $00)
        entityfx(local0\Field1, $09)
        entityblend(local0\Field1, $03)
        entitycolor(local0\Field1, (Float arg6), (Float arg7), (Float arg8))
        entityparent(local0\Field1, local0\Field0, $01)
        hideentity(local0\Field1)
        local0\Field2 = createsprite($00)
        positionentity(local0\Field2, arg1, arg2, arg3, $00)
        scalesprite(local0\Field2, rnd(0.36, 0.4), rnd(0.36, 0.4))
        entitytexture(local0\Field2, misc_i\Field3, $00, $00)
        entityfx(local0\Field2, $09)
        entityblend(local0\Field2, $03)
        entityorder(local0\Field2, $FFFFFFFF)
        entitycolor(local0\Field2, (Float arg6), (Float arg7), (Float arg8))
        rotateentity(local0\Field2, 0.0, 0.0, rnd(360.0, 0.0), $00)
        spriteviewmode(local0\Field2, $01)
        entityparent(local0\Field2, local0\Field0, $01)
        hideentity(local0\Field2)
    EndIf
    local0\Field10 = (((Float ((arg6 + arg7) + arg8)) / 255.0) / 3.0)
    If (arg0 <> Null) Then
        If (rand($32, $01) = $01) Then
            local2 = arg0\Field7\Field6
            If ((((((local2 <> $04) And (local2 <> $47)) And (local2 <> $49)) And (local2 <> $69)) And (local2 <> $6A)) <> 0) Then
                local0\Field11 = $01
            EndIf
        EndIf
    EndIf
    Return local0
    Return Null
End Function
