Function validateauthticket%(arg0.authconnection)
    Local local0%
    If (server\Field87\Field7 = $00) Then
        Return $00
    EndIf
    If (((gs_getsteamserversconnected() = $01) And (gs_isloggedon() = $01)) <> 0) Then
        local0 = gs_beginauthsession(arg0\Field9, banksize(arg0\Field9), steam_stringtoidupper(arg0\Field7), steam_stringtoidlower(arg0\Field7))
        Return local0
    ElseIf (((gs_isloggedon() <> $01) Or (gs_getsteamserversconnected() <> $01)) <> 0) Then
        Return $FFFFFFFF
    EndIf
    Return $00
End Function
