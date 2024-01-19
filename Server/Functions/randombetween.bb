Function randombetween%(arg0%, arg1%)
    If (rand($01, $02) = $01) Then
        Return arg0
    Else
        Return arg1
    EndIf
    Return $00
End Function
