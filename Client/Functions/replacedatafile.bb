Function replacedatafile%(arg0%, arg1$, arg2%)
    Local local0%
    Local local1$
    Local local2%
    Local local4%
    If (filetype(arg1) <> $00) Then
        deletefile(arg1)
    EndIf
    local2 = writefile(arg1)
    If (local2 = $00) Then
        runtimeerror("Can't read data file")
    EndIf
    Select arg0
        Case $01
            Restore DATA_00000000
        Case $02
            Restore DATA_000001D0
        Case $03
            Restore DATA_00001948
        Default
            Return $00
    End Select
    Read local0
    For local4 = $01 To local0 Step $01
        Read local1
        writeline(local2, local1)
    Next
    closefile(local2)
    If (arg2 <> 0) Then
        openfile(arg1)
    EndIf
    updateinifile(arg1)
    Return $01
    Return $00
End Function
