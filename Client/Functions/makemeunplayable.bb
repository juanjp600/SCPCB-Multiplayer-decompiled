Function makemeunplayable%()
    If (me\Field9 <> 0) Then
        resetselectedstuff()
        me\Field9 = $00
    EndIf
    Return $00
End Function
