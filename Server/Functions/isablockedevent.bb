Function isablockedevent%(arg0.events)
    If (arg0\Field24 = $01) Then
        Return $01
    EndIf
    Select arg0\Field22
        Case $22
            Return $01
        Case $3B,$3F
            Return $01
        Case $06
            Return $01
        Case $1E
            Return $01
        Case $4A
            Return $01
        Case $02
            Return $01
        Case $3E
            Return $01
        Case $39
            Return $01
    End Select
    Return $00
    Return $00
End Function
