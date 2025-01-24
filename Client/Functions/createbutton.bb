Function createbutton%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7%, arg8%)
    Local local0%
    local0 = copyentity(d_i\Field2[arg0], $00)
    scaleentity(local0, 0.03, 0.03, 0.03, $00)
    positionentity(local0, arg1, arg2, arg3, $00)
    rotateentity(local0, arg4, arg5, arg6, $00)
    entitypickmode(local0, $02, $01)
    If (arg8 <> 0) Then
        entitytexture(local0, d_i\Field3[$02], $00, $00)
    EndIf
    If (arg7 <> $00) Then
        entityparent(local0, arg7, $01)
    EndIf
    Return local0
    Return $00
End Function
