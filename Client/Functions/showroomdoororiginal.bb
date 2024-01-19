Function showroomdoororiginal%(arg0.doors)
    If (arg0\Field0 <> $00) Then
        showentity(arg0\Field0)
        entityalpha(arg0\Field0, 1.0)
    EndIf
    If (arg0\Field2 <> $00) Then
        showentity(arg0\Field2)
        entityalpha(arg0\Field2, 1.0)
    EndIf
    If (arg0\Field1 <> $00) Then
        showentity(arg0\Field1)
        entityalpha(arg0\Field1, 1.0)
    EndIf
    If (arg0\Field3[$00] <> $00) Then
        showentity(arg0\Field3[$00])
        entityalpha(arg0\Field3[$00], 1.0)
    EndIf
    If (arg0\Field3[$01] <> $00) Then
        showentity(arg0\Field3[$01])
        entityalpha(arg0\Field3[$01], 1.0)
    EndIf
    Return $00
End Function
