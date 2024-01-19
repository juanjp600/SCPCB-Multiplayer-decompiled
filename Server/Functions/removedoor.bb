Function removedoor%(arg0.doors)
    If (arg0\Field3[$00] <> $00) Then
        entityparent(arg0\Field3[$00], $00, $01)
    EndIf
    If (arg0\Field3[$01] <> $00) Then
        entityparent(arg0\Field3[$01], $00, $01)
    EndIf
    If (arg0\Field0 <> $00) Then
        freeentity(arg0\Field0)
    EndIf
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
    EndIf
    If (arg0\Field2 <> $00) Then
        freeentity(arg0\Field2)
    EndIf
    If (arg0\Field3[$00] <> $00) Then
        freeentity(arg0\Field3[$00])
    EndIf
    If (arg0\Field3[$01] <> $00) Then
        freeentity(arg0\Field3[$01])
    EndIf
    mp_door[arg0\Field18] = Null
    Delete arg0
    Return $00
End Function
