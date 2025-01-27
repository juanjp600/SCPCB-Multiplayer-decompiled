Function mp_server_fillplayersglobaldata%()
    Local local0%
    Local local1.mp_modelmesh
    Local local2.mp_modeltexture
    Local local3.mp_attachmodel
    For local1 = Each mp_modelmesh
        If (local1\Field3 = $00) Then
            mp_writebyte(local1\Field0)
            mp_writeline(local1\Field1)
            mp_writeline(local1\Field4\Field1)
            mp_writeline(local1\Field4\Field0)
            mp_writeline(local1\Field4\Field2)
            mp_writeline(local1\Field4\Field3)
            mp_writebyte(local1\Field4\Field8)
            mp_writeshort(convertfloattoshort(local1\Field4\Field10, 10.0))
            mp_writeshort(convertfloattoshort(local1\Field4\Field9, 10.0))
            mp_writebyte(local1\Field4\Field7)
            mp_writebyte(local1\Field4\Field6)
            mp_writebyte(local1\Field4\Field4)
            mp_writebyte(local1\Field4\Field5)
            mp_writefloat(local1\Field4\Field12)
            mp_writefloat(local1\Field4\Field11)
            mp_writeshort(convertfloattoshort(local1\Field4\Field14, 10.0))
            mp_writeshort(convertfloattoshort(local1\Field4\Field15, 10.0))
            mp_writeshort(convertfloattoshort(local1\Field4\Field16, 10.0))
            mp_writefloat(local1\Field4\Field17)
            mp_writefloat(local1\Field4\Field18)
            mp_writefloat(local1\Field4\Field19)
            mp_writeshort(convertfloattoshort(local1\Field4\Field20, 10.0))
            mp_writeshort(convertfloattoshort(local1\Field4\Field21, 10.0))
            mp_writeshort(convertfloattoshort(local1\Field4\Field22, 10.0))
            mp_writeline(local1\Field4\Field13)
            For local0 = $01 To $13 Step $01
                If (local1\Field4\Field23[local0] <> $00) Then
                    mp_writebyte(local0)
                    mp_writeint(local1\Field4\Field23[local0])
                    mp_writefloat(local1\Field4\Field24[local0])
                    mp_writefloat(local1\Field4\Field25[local0])
                    mp_writebyte(local1\Field4\Field28[local0])
                EndIf
            Next
            mp_writebyte($00)
            For local0 = $00 To $03 Step $01
                mp_writeint(local1\Field4\Field26[local0])
                mp_writefloat(local1\Field4\Field27[local0])
            Next
            For local0 = $00 To $03 Step $01
                mp_writeline(local1\Field4\Field30[local0])
            Next
        EndIf
    Next
    mp_writebyte($00)
    For local2 = Each mp_modeltexture
        If (local2\Field5 = $00) Then
            mp_writebyte(local2\Field0)
            mp_writeline(local2\Field1)
        EndIf
    Next
    mp_writebyte($00)
    For local3 = Each mp_attachmodel
        If (local3\Field5 = $00) Then
            mp_writebyte(local3\Field0)
            For local0 = $00 To $03 Step $01
                mp_writeline(local3\Field1[local0])
                If (local3\Field1[local0] <> "") Then
                    mp_writeline(local3\Field2[local0])
                EndIf
            Next
            For local0 = $00 To $03 Step $01
                mp_writeline(local3\Field7[local0])
            Next
            For local0 = $01 To $3F Step $01
                If (local3\Field9[local0] <> Null) Then
                    mp_writebyte(local0)
                    mp_writeline(local3\Field9[local0]\Field0)
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field4, 10.0))
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field5, 10.0))
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field6, 10.0))
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field1, 10.0))
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field2, 10.0))
                    mp_writeshort(convertfloattoshort(local3\Field9[local0]\Field3, 10.0))
                    mp_writefloat(local3\Field9[local0]\Field7)
                    mp_writebyte(local3\Field9[local0]\Field8)
                EndIf
            Next
            mp_writebyte($00)
        EndIf
    Next
    mp_writebyte($00)
    Return $00
End Function
