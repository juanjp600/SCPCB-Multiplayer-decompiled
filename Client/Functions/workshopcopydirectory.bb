Function workshopcopydirectory$(arg0$, arg1$, arg2%)
    Local local0$
    Local local1%
    Local local2$
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    If (filetype(arg1) = $01) Then
        Return "0"
    EndIf
    If (filetype(arg1) = $00) Then
        createdirectories(arg1)
    EndIf
    scandir(arg0)
    local0 = (strippath(arg0) + "\")
    For local1 = $00 To (currentscanneddirs - $01) Step $01
        If (scanneddir[local1] <> "") Then
            local2 = (arg1 + replace((stripdirectorypath(scanneddir[local1], local0) + "\"), ((Str arg2) + "\"), ""))
            createdirectories(left(local2, len(local2)))
        EndIf
    Next
    local3 = createbank($08)
    local4 = createbank($08)
    local5 = createbank($08)
    local6 = createbank($80)
    For local1 = $00 To (currentscannedfiles - $01) Step $01
        If (scanneddirfiles[local1] <> "") Then
            local8 = $00
            local7 = $00
            local11 = (arg1 + replace(stripdirectorypath(scanneddirfiles[local1], local0), ((Str arg2) + "\"), ""))
            local9 = api_createfile(scanneddirfiles[local1], $80000000, $01, local6, $03, $40000080, $00)
            local10 = api_createfile(local11, $80000000, $01, local6, $03, $40000080, $00)
            api_getfiletime(local9, local3, local4, local5)
            local7 = (peekint(local5, $00) + peekint(local5, $04))
            api_closehandle(local9)
            If (local10 <> $FFFFFFFF) Then
                api_getfiletime(local10, local3, local4, local5)
                local8 = (peekint(local5, $00) + peekint(local5, $04))
                api_closehandle(local10)
            EndIf
            If (((local7 <> local8) Or (local8 = $00)) <> 0) Then
                copyfile(scanneddirfiles[local1], local11)
            EndIf
        EndIf
    Next
    freebank(local3)
    freebank(local4)
    freebank(local5)
    freebank(local6)
    Return local0
    Return ""
End Function
