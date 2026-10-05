Function microsecs%()
    retvalmillisecs = getmicrosecs()
    If (retvalmillisecs < $00) Then
        retvalmillisecs = (retvalmillisecs + $7FFFFFFF)
    EndIf
    Return retvalmillisecs
    Return $00
End Function
