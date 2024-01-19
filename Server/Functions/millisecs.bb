Function millisecs%()
    retvalmillisecs = api_timegettime()
    If (retvalmillisecs < $00) Then
        retvalmillisecs = (retvalmillisecs + $80000000)
    EndIf
    Return retvalmillisecs
    Return $00
End Function
