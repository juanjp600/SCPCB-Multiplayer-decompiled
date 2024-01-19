Function se_vf_savebin%(arg0$, arg1$)
    Local local0%
    Local local1.se_vf_inst
    Local local2.se_vf_funcptr
    Local local3.se_vf_label
    Local local4.se_vf_public
    Local local5%
    local0 = writefile(arg0)
    If (local0 = $00) Then
        Return $00
    EndIf
    writeint(local0, se_vf_inst_n)
    writeint(local0, se_vf_func_ptr_n)
    writeint(local0, se_vf_static_n)
    writeint(local0, se_vf_label_n)
    writeint(local0, se_vf_public_n)
    For local2 = Each se_vf_funcptr
        writestring(local0, local2\Field0)
        writeint(local0, local2\Field2\Field4)
        writeint(local0, local2\Field3\Field4)
        writeint(local0, local2\Field4)
        writeint(local0, local2\Field5)
    Next
    For local3 = Each se_vf_label
        If (local3\Field1 = Null) Then
            local3\Field1 = (First se_vf_inst)
        ElseIf (local3\Field2 <> 0) Then
            local3\Field1 = (After local3\Field1)
        EndIf
        writeint(local0, local3\Field1\Field4)
    Next
    For local4 = Each se_vf_public
        writestring(local0, local4\Field0)
        writeint(local0, local4\Field1)
    Next
    For local1 = Each se_vf_inst
        writebyte(local0, local1\Field0)
        debuglog((Str local1\Field0))
        If (local1\Field1 <> Null) Then
            writebyte(local0, local1\Field1\Field0)
            Select local1\Field1\Field0
                Case $01
                    writeint(local0, (Int local1\Field1\Field1))
                Case $02
                    writefloat(local0, (Float local1\Field1\Field1))
                Case $03
                    writestring(local0, local1\Field1\Field1)
                Default
                    writeint(local0, local1\Field1\Field2)
            End Select
        EndIf
        If (local1\Field2 <> Null) Then
            writebyte(local0, local1\Field2\Field0)
            Select local1\Field2\Field0
                Case $01
                    writeint(local0, (Int local1\Field2\Field1))
                Case $02
                    writefloat(local0, (Float local1\Field2\Field1))
                Case $03
                    writestring(local0, local1\Field2\Field1)
                Default
                    writeint(local0, local1\Field2\Field2)
            End Select
        EndIf
        If (local1\Field3 <> Null) Then
            writebyte(local0, local1\Field3\Field0)
            Select local1\Field3\Field0
                Case $01
                    writeint(local0, (Int local1\Field3\Field1))
                Case $02
                    writefloat(local0, (Float local1\Field3\Field1))
                Case $03
                    writestring(local0, local1\Field3\Field1)
                Default
                    writeint(local0, local1\Field3\Field2)
            End Select
        EndIf
    Next
    If (instr(arg1, "ignoreversion", $01) = $00) Then
        writeline(local0, "1.0.1")
    EndIf
    closefile(local0)
    Return $00
End Function
