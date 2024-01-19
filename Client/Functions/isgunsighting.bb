Function isgunsighting%()
    If (eqquipedgun <> Null) Then
        Return eqquipedgun\Field29
    EndIf
    Return $00
End Function
