Function init294drinks%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local0 = jsonparsefromfile((lang\Field1 + "Data\SCP-294.jsonc"))
    If (jsonisarray(local0) <> 0) Then
        i_294\Field3 = jsongetarray(local0)
    Else
        i_294\Field3 = jsongetarray(jsonparsefromfile("Data\SCP-294.jsonc"))
    EndIf
    i_294\Field2 = creates2imap()
    local3 = jsongetarraysize(i_294\Field3)
    For local1 = $00 To (local3 - $01) Step $01
        local4 = jsongetarray(jsongetvalue(jsongetarrayvalue(i_294\Field3, local1), "name"))
        local5 = jsongetarraysize(local4)
        For local2 = $00 To (local5 - $01) Step $01
            s2imapset(i_294\Field2, upper(jsongetstring(jsongetarrayvalue(local4, local2))), local1)
        Next
    Next
    Return $00
End Function
