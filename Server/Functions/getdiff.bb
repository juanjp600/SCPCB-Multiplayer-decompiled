Function getdiff%(arg0$)
    Select arg0
        Case "safe"
            Return $00
        Case "euclid"
            Return $01
        Case "keter"
            Return $02
    End Select
    Return $00
    Return $00
End Function