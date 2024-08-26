Function file_getfilename$(arg0$)
    Local local0$
    If (arg0 = "") Then
        Return ""
    EndIf
    local0 = file_splitafterchar(file_convertslashes(arg0), "/")
    If (local0 = "") Then
        local0 = arg0
    EndIf
    Return local0
    Return ""
End Function
