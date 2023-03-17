Presentation Dailyclean

## About

Daily clean is all you to turn on or off automatically or manually all your pods your kubernetes namespace.
Save the planet with DailyClean.
Daily clean only use kubernetes native API.

![DailyClean Automation](./dailyclean-configuration.png "DailyClean Automation")

## Getting Started

First, be sure that you added your docker hub account in openshift. Please follow this tutorial : https://developers.redhat.com/blog/2021/02/18/how-to-work-around-dockers-new-download-rate-limit-on-red-hat-openshift?source=sso#

Customize the scripts in demo/openshift in order to set your own parameters (sandbox / workspace names, patch workspace with axa.com/dailyclean: "false" added ect ...)

To test dailyclean on your openshift dev sandbox, please use these commands:

```
git clone https://github.com/guillaume-thomas/dailyclean-presentation.git
cd dailyclean-presentation/demo/openshift
# Create dailyclean serviceaccount
oc apply -f dailyclean-serviceaccount.yml
# Link your docker account to this service account in order to pull images
oc secret link dailyclean docker --for=pull
oc label deployment workspace1186435ab42e489c axa.com/dailyclean=false
# Install dailyclean for the default service account
oc apply -f deployment-dailyclean.yml
# Install three instances of kubernetes-bootcamp
oc apply -f deployment-others.yml
# Install quake3
oc apply -f deployment-q3.yml
```

To reset your namespace : 

```
oc delete deployments/dailyclean-api
oc delete deployments/kubernetes-bootcamp1
oc delete deployments/kubernetes-bootcamp2
oc delete deployments/kubernetes-bootcamp3
oc delete deployments/quake

oc delete services/dailyclean-api
oc delete services/kubernetes-bootcamp1
oc delete services/kubernetes-bootcamp2
oc delete services/kubernetes-bootcamp3
oc delete services/quake

oc delete routes/dailyclean
oc delete routes/quake

oc delete configmaps/quake3-server-config

rm -rf dailyclean-presentation
```