Function voice_start%()
    If (((voice\Field2 = $00) And (voice\Field0 <> $00)) <> 0) Then
        voice\Field2 = snd_in_open(voice\Field0, voice_getbytes(), $08)
        debuglog(("opened: " + (Str voice_getbytes())))
        If (voice\Field2 <> $00) Then
            snd_in_start(voice\Field2)
        EndIf
    EndIf
    Return voice\Field2
    Return $00
End Function
