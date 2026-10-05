Function isgunsighting%()
    If (eqquipedgun <> Null) Then
        Return eqquipedgun\Field31
    EndIf
    Return $00
End Function
