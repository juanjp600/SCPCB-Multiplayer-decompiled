Function removeauthconnection%(arg0.authconnection)
    If (server\Field87\Field7 <> 0) Then
        gs_endauthsession(steam_stringtoidupper(arg0\Field7), steam_stringtoidlower(arg0\Field7))
    EndIf
    If (arg0\Field9 <> $00) Then
        freebank(arg0\Field9)
    EndIf
    Delete arg0
    Return $00
End Function
