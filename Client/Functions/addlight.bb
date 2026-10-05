Function addlight%(arg0.rooms, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%, arg8%, arg9%)
    Local local0%
    Local local1%
    If (arg0 <> Null) Then
        For local0 = $00 To $1F Step $01
            If (arg0\Field16[local0] = $00) Then
                arg0\Field16[local0] = createlight(arg4, $00)
                arg0\Field20[local0] = createpivot($00)
                positionentity(arg0\Field20[local0], arg1, arg2, arg3, $00)
                entityparent(arg0\Field20[local0], arg0\Field3, $01)
                lightrange(arg0\Field16[local0], arg5)
                lightcolor(arg0\Field16[local0], (Float arg6), (Float arg7), (Float arg8))
                positionentity(arg0\Field16[local0], arg1, arg2, arg3, $00)
                entityparent(arg0\Field16[local0], arg0\Field3, $01)
                arg0\Field17[local0] = (((Float ((arg6 + arg7) + arg8)) / 255.0) / 3.0)
                arg0\Field24[local0] = createsprite($00)
                positionentity(arg0\Field24[local0], arg1, arg2, arg3, $00)
                scalesprite(arg0\Field24[local0], 0.13, 0.13)
                entitytexture(arg0\Field24[local0], lightspritetex($00), $00, $00)
                entityblend(arg0\Field24[local0], $03)
                entityfx(arg0\Field24[local0], $09)
                entitycolor(arg0\Field24[local0], (Float arg6), (Float arg7), (Float arg8))
                entityparent(arg0\Field24[local0], arg0\Field3, $01)
                arg0\Field21[local0] = createsprite($00)
                positionentity(arg0\Field21[local0], arg1, arg2, arg3, $00)
                scalesprite(arg0\Field21[local0], 0.66, 0.66)
                entitytexture(arg0\Field21[local0], lightspritetex($02), $00, $00)
                entityblend(arg0\Field21[local0], $03)
                entityorder(arg0\Field21[local0], $FFFFFFFF)
                entitycolor(arg0\Field21[local0], (Float arg6), (Float arg7), (Float arg8))
                entityparent(arg0\Field21[local0], arg0\Field3, $01)
                entityfx(arg0\Field21[local0], $09)
                rotatesprite(arg0\Field21[local0], (Float rand($168, $01)))
                arg0\Field19[local0] = $01
                hideentity(arg0\Field21[local0])
                arg0\Field23[local0] = rand($01, $0A)
                arg0\Field53[local0] = (Float arg6)
                arg0\Field54[local0] = (Float arg7)
                arg0\Field55[local0] = (Float arg8)
                hideentity(arg0\Field16[local0])
                arg0\Field18 = local0
                Return arg0\Field16[local0]
            EndIf
        Next
    Else
        local1 = createsprite($00)
        positionentity(local1, arg1, arg2, arg3, $00)
        scalesprite(local1, 0.13, 0.13)
        entitytexture(local1, lightspritetex($00), $00, $00)
        entityblend(local1, $03)
        entitycolor(local1, (Float arg6), (Float arg7), (Float arg8))
        If (arg9 <> $00) Then
            entityparent(local1, arg9, $01)
        EndIf
        Return local1
    EndIf
    Return $00
End Function
