Function multiplayer_breach_createviewmodelforrole%(arg0%, arg1$, arg2#, arg3#, arg4#, arg5#)
    Local local0.breachtypes
    If (0.0 = arg5) Then
        arg5 = arg4
    EndIf
    local0 = getbreachtype(arg0)
    If (local0\Field20 <> $00) Then
        freeentity(local0\Field20)
    EndIf
    local0\Field20 = loadanimmesh_strict(arg1, $00)
    scaleentity(local0\Field20, arg4, arg4, arg5, $00)
    entityparent(local0\Field20, viewmodelpivot, $01)
    moveentity(local0\Field20, 0.0, arg2, arg3)
    hideentity(local0\Field20)
    Return $00
End Function
