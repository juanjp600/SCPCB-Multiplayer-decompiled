Function isgunshooting%()
    If (eqquipedgun <> Null) Then
        Return (1.01 <= eqquipedgun\Field3)
    EndIf
    Return $00
End Function
