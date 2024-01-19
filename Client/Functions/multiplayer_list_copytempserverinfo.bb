Function multiplayer_list_copytempserverinfo%(arg0.tempservers, arg1.servers, arg2%)
    Local local0%
    If (arg2 <> 0) Then
        arg0\Field1 = arg1\Field1
        arg0\Field2 = arg1\Field2
        arg0\Field18 = arg1\Field18
        arg0\Field14 = arg1\Field14
        arg0\Field0 = arg1\Field0
    EndIf
    arg0\Field4 = arg1\Field4
    arg0\Field10 = arg1\Field10
    arg0\Field6 = arg1\Field6
    arg0\Field7 = arg1\Field7
    arg0\Field8 = arg1\Field8
    arg0\Field3 = arg1\Field3
    arg0\Field16 = arg1\Field16
    arg0\Field5 = arg1\Field5
    arg0\Field9 = arg1\Field9
    arg0\Field21 = arg1\Field20
    arg0\Field9 = arg1\Field9
    arg0\Field22 = arg1\Field21
    arg0\Field23 = arg1\Field22
    arg0\Field19 = arg1\Field19
    arg0\Field25 = arg1\Field23
    arg0\Field26 = arg1\Field25
    For local0 = $00 To $13 Step $01
        arg0\Field24[local0] = arg1\Field24[local0]
    Next
    Return $00
End Function
