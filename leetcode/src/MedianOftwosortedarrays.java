
class MedianOftwosortedarrays {
    public static void main(String[] args) {
            int[] a={1,4,5};
            int[] b={3,6};
            new MedianOftwosortedarrays().findMedianSortedArrays(a,b);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int median = (nums1.length + nums2.length) / 2;
                boolean even = false;
                if ((nums1.length + nums2.length) % 2 == 0)
                    even = true;
                int i=-1,j=0,k=0;
                char ch='a';
                while(i<median)
                {
                    while(j<nums1.length &&  k<nums2.length && nums1[j]<nums2[k] && i<median ){
                        System.out.println(i+" "+j+" "+k+"j");
                        ch='j';
                        j++;
                        i++;
                    }
                    while( j<nums1.length && k<nums2.length && nums2[k]<=nums1[j] && i<median){
                        System.out.println(i+" "+j+" "+k+"k");
                        ch='k';
                        k++;
                        i++;
                    }

                }

                if(ch=='j')

                    if(even)
                        return (nums1[j]+nums1[j-1])/2;
                    else
                        return nums1[j];
                else{
                    if(even)
                        return (nums2[k]+nums2[k-1])/2;
                    else
                        return nums2[k];
                }

            }

}