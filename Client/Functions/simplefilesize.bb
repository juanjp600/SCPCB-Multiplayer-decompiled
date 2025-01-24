Function simplefilesize$(arg0%)
    Local local0#
    local0 = (Float arg0)
    If (arg0 >= $100000) Then
        If (arg0 >= $40000000) Then
            Return ((Str (ceil(((((local0 / 1024.0) / 1024.0) / 1024.0) * 100.0)) / 100.0)) + "GB")
        Else
            Return ((Str (ceil((((local0 / 1024.0) / 1024.0) * 100.0)) / 100.0)) + "MB")
        EndIf
    Else
        Return ((Str (ceil(((local0 / 1024.0) * 100.0)) / 100.0)) + "KB")
    EndIf
    Return ""
End Function
