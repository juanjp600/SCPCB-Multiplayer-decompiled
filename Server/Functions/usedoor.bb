Function usedoor%(arg0.doors, arg1%, arg2%, arg3%, arg4%)
    Local local0.itemtemplates
    Local local1%
    Local local3%
    local1 = $00
    If (isvalidplayer(arg3) <> 0) Then
        If (player[arg3] <> Null) Then
            If (((arg4 > $00) And (arg4 < $3E8)) <> 0) Then
                If (m_item[arg4] <> Null) Then
                    If (m_item[arg4]\Field22 = arg3) Then
                        local0 = m_item[arg4]\Field3
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (arg0\Field12 > $00) Then
        If (local0 = Null) Then
            Return $00
        Else
            Select local0\Field2
                Case "key1"
                    local1 = $01
                Case "key2"
                    local1 = $02
                Case "key3"
                    local1 = $03
                Case "key4"
                    local1 = $04
                Case "key5"
                    local1 = $05
                Case "key6"
                    local1 = $06
                Default
                    local1 = $FFFFFFFF
            End Select
            local0 = Null
            If (local1 = $FFFFFFFF) Then
                Return $00
            ElseIf (local1 < arg0\Field12) Then
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field12 < $00) Then
        If (local0 <> Null) Then
            local1 = (((local0\Field2 = "hand") And (arg0\Field12 = $FFFFFFFF)) Or ((local0\Field2 = "hand2") And (arg0\Field12 = $FFFFFFFE)))
        EndIf
        If (local1 <> $00) Then
            local0 = Null
        Else
            Return $00
        EndIf
    ElseIf (arg0\Field4 <> 0) Then
        Return $00
    EndIf
    arg0\Field5 = (arg0\Field5 = $00)
    If (arg0\Field22 <> Null) Then
        arg0\Field22\Field5 = (arg0\Field22\Field5 = $00)
    EndIf
    local3 = $00
    If (arg0\Field9 = $01) Then
        local3 = rand($00, $01)
    Else
        local3 = rand($00, $02)
    EndIf
    If (arg2 = $01) Then
        If (arg0\Field5 <> 0) Then
            If (arg0\Field22 <> Null) Then
                arg0\Field22\Field11 = (Float arg0\Field22\Field10)
            EndIf
            arg0\Field11 = (Float arg0\Field10)
        EndIf
    ElseIf (arg0\Field5 <> 0) Then
        If (arg0\Field22 <> Null) Then
            arg0\Field22\Field11 = (Float arg0\Field22\Field10)
        EndIf
        arg0\Field11 = (Float arg0\Field10)
    EndIf
    Return $00
End Function
