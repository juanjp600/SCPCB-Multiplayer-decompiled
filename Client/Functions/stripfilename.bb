Function stripfilename$(arg0$)
    Local local0$
    Local local1%
    Local local2%
    local0 = ""
    local1 = $00
    If (len(arg0) > $00) Then
        For local2 = $01 To len(arg0) Step $01
            local0 = mid(arg0, local2, $01)
            If (((local0 = "\") Or (local0 = "/")) <> 0) Then
                local1 = local2
            EndIf
        Next
    EndIf
    Return left(arg0, local1)
    Return ""
End Function
