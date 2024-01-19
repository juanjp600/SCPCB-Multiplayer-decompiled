Function voice_init%()
    voice\Field3 = (filesize("vlib.dll") <> $00)
    voice\Field5 = $BB80
    If (voice\Field3 <> 0) Then
        voice_create($BB80)
    EndIf
    Return $00
End Function
