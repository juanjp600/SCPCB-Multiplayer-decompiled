Function mp_updateplayerposition%(arg0.players, arg1%)
    If (arg1 = $00) Then
        positionentity(arg0\Field62, arg0\Field0, arg0\Field1, arg0\Field2, $00)
        resetentity(arg0\Field62)
    Else
        arg0\Field0 = entityx(arg0\Field62, $00)
        arg0\Field1 = entityy(arg0\Field62, $00)
        arg0\Field2 = entityz(arg0\Field62, $00)
    EndIf
    positionentity(arg0\Field63, arg0\Field0, arg0\Field1, arg0\Field2, $00)
    resetentity(arg0\Field63)
    mp_setroomnametoplayer(arg0)
    arg0\Field86 = 0.01
    arg0\Field150 = entityx(arg0\Field63, $00)
    arg0\Field151 = entityy(arg0\Field63, $00)
    arg0\Field152 = entityz(arg0\Field63, $00)
    arg0\Field170 = arg0\Field32
    Return $00
End Function
