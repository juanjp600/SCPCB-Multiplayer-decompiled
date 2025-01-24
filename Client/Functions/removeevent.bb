Function removeevent%(arg0.events)
    If (arg0\Field11 <> 0) Then
        If (arg0\Field6 <> $00) Then
            stopstream_strict(arg0\Field6)
            arg0\Field11 = $00
        EndIf
    Else
        stopchannel(arg0\Field6)
    EndIf
    arg0\Field6 = $00
    If (arg0\Field12 <> 0) Then
        If (arg0\Field7 <> $00) Then
            stopstream_strict(arg0\Field7)
            arg0\Field12 = $00
        EndIf
    Else
        stopchannel(arg0\Field7)
    EndIf
    arg0\Field7 = $00
    If (arg0\Field8 <> $00) Then
        freesound_strict(arg0\Field8)
        arg0\Field8 = $00
    EndIf
    If (arg0\Field9 <> $00) Then
        freesound_strict(arg0\Field9)
        arg0\Field9 = $00
    EndIf
    If (arg0\Field14 <> $00) Then
        freeimage(arg0\Field14)
        arg0\Field14 = $00
    EndIf
    If (arg0\Field15 <> $00) Then
        freeimage(arg0\Field15)
        arg0\Field15 = $00
    EndIf
    Delete arg0
    Return $00
End Function
