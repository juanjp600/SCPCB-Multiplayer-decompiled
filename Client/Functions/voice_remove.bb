Function voice_remove%()
    If (voice\Field3 <> 0) Then
        voice_free()
        voice\Field3 = $00
    EndIf
    Return $00
End Function
