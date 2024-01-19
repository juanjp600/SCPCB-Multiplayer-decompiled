Function removeauthconnection%(arg0.authconnection)
    If (arg0\Field9 <> $00) Then
        freebank(arg0\Field9)
    EndIf
    Delete arg0
    Return $00
End Function
