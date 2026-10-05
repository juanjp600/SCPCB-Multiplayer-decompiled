Function mp_updateplayerposition%(arg0.players, arg1%)
    If (arg1 = $00) Then
        positionentity(arg0\Field64, arg0\Field0, arg0\Field1, arg0\Field2, $00)
        resetentity(arg0\Field64)
    Else
        arg0\Field0 = entityx(arg0\Field64, $00)
        arg0\Field1 = entityy(arg0\Field64, $00)
        arg0\Field2 = entityz(arg0\Field64, $00)
    EndIf
    positionentity(arg0\Field65, arg0\Field0, arg0\Field1, arg0\Field2, $00)
    resetentity(arg0\Field65)
    mp_setroomnametoplayer(arg0)
    arg0\Field88 = 0.01
    arg0\Field153 = entityx(arg0\Field65, $00)
    arg0\Field154 = entityy(arg0\Field65, $00)
    arg0\Field155 = entityz(arg0\Field65, $00)
    arg0\Field173 = arg0\Field32
    Return $00
End Function
