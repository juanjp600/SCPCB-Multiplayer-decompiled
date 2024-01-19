Function addentitytoroomprops%(arg0.rooms, arg1%)
    If (arg1 <> $00) Then
        arg0\Field76 = (arg0\Field76 + $01)
        arg0\Field75[arg0\Field76] = arg1
        Return arg0\Field76
    EndIf
    Return $00
    Return $00
End Function
