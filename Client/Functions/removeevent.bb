Function removeevent%(arg0.events)
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (arg0\Field7 <> $00) Then
        freesound_strict(arg0\Field7)
    EndIf
    If (arg0\Field8 <> $00) Then
        freesound_strict(arg0\Field8)
    EndIf
    If (arg0\Field12 <> $00) Then
        freeimage(arg0\Field12)
    EndIf
    debuglog(("Removed " + arg0\Field0))
    Delete arg0
    Return $00
End Function
