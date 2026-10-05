Function loadcaliberimages%()
    If (calibers <> $00) Then
        unloadcaliberimages()
    EndIf
    Return $00
End Function
