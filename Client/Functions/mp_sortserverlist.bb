Function mp_sortserverlist%(arg0%, arg1%)
    Local local0%
    Local local1%
    For local0 = $00 To $04 Step $01
        If (local0 <> arg1) Then
            serverlist\Field6[local0] = $00
        EndIf
    Next
    serverlist\Field7 = arg1
    serverlist\Field6[arg1] = (serverlist\Field6[arg1] + $01)
    If (serverlist\Field6[arg1] > $02) Then
        serverlist\Field6[arg1] = $00
    EndIf
    mp_fillserverlist(arg0)
    If (serverlist\Field6[arg1] = $00) Then
        Return $00
    EndIf
    local1 = mp_fillserverlist(arg0)
    Select arg1
        Case $00
            For local0 = $00 To (local1 - $01) Step $01
                pushsortvalue_string((Handle listservers[local0]), listservers[local0]\Field2)
            Next
            sortstringvalues((serverlist\Field6[arg1] = $02))
        Case $01
            For local0 = $00 To (local1 - $01) Step $01
                pushsortvalue_string((Handle listservers[local0]), listservers[local0]\Field3)
            Next
            sortstringvalues((serverlist\Field6[arg1] = $02))
        Case $02
            For local0 = $00 To (local1 - $01) Step $01
                pushsortvalue_int((Handle listservers[local0]), listservers[local0]\Field4)
            Next
            sortintvalues((serverlist\Field6[arg1] = $02))
        Case $03
            For local0 = $00 To (local1 - $01) Step $01
                pushsortvalue_int((Handle listservers[local0]), listservers[local0]\Field6)
            Next
            sortintvalues((serverlist\Field6[arg1] = $02))
    End Select
    For local0 = $00 To (local1 - $01) Step $01
        listservers[local0] = (Object.mp_listserver getsortidentifier(local0))
    Next
    clearsortvalues()
    Return $00
End Function
